package com.cyh.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.b1.util.FilePathGenerator;
import com.cyh.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	//@Autowired
	//private ServletContext servletContext;
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public boolean memberJoinValidate(MemberVO memberVO,BindingResult bindingResult)throws Exception {
		boolean check=false;//true => error,false => ok
		
		//annotation 검증 결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		
		//pw와 pw2가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;
			bindingResult.rejectValue("pw2","memberVO.pw.notEqual" );
													//form의 path명, 출력하고싶은 properties의키 
		}
		
		//id가 중복인지 검증
		memberVO = memberMapper.memberIdCheck(memberVO);
		
		if(memberVO != null) {
			check= true;
			bindingResult.rejectValue("id", "memberVO.id.notEqual" );
			
		}
		
		
		
		return check;
		
	}
	

	//파일 셀렉트
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO)throws Exception {
		
		return memberFilesMapper.memberFilesSelect(memberFilesVO);
	}
	
	
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception {
		
		//String filePath =servletContext.getRealPath("upload");
		
		//System.out.println(filePath);
	
					//파일을 저장할 폴더
		File file =filePathGenerator.getUseClassPathResource("upload");
		String fileName=fileSaver.save(file, files);
		
		System.out.println(fileName);
		int result = memberMapper.memberJoin(memberVO);
		 
		MemberFilesVO memberFilesVO= new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		
	    result =memberFilesMapper.memberFilesInsert(memberFilesVO);
		return result; //memberMapper.memberJoin(memberVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception {
		
		return memberMapper.memberLogin(memberVO);
	}

}
