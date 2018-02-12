package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UploadFile {
	
	public static List upload(HttpServletRequest request) {
		List filename = new ArrayList();
		long  startTime=System.currentTimeMillis();
		String imgtype = request.getParameter("imgtype");
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
            
           while(iter.hasNext())
           {
               //一次遍历所有文件
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null)
               {
                   String path= request.getSession().getServletContext().getRealPath("/")+"/img/"+imgtype+"/"+file.getName();
                   System.out.println(path);
                   filename.add(file.getName());
                   //上传"
                   try {
					file.transferTo(new File(path));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
                
           }
          
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("上传时间："+String.valueOf(endTime-startTime)+"ms");
       return filename;
	}
}
