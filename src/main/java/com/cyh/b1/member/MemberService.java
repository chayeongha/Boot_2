package com.cyh.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.b1.util.FilePathGenerator;
import com.cyh.b1.util.FileSaver;

@Service
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
	

}
