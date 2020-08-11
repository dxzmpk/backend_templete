package com.dxzmpk.edu_backend.controller;

import com.dxzmpk.edu_backend.dto.HttpResponse;
import com.dxzmpk.edu_backend.dto.HttpResponseSingle;
import com.dxzmpk.edu_backend.util.CONSTLIST;
import com.dxzmpk.edu_backend.util.fileupload.StorageException;
import com.dxzmpk.edu_backend.util.fileupload.StorageFileNotFoundException;
import com.dxzmpk.edu_backend.util.fileupload.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Api(tags={"文件上传接口"},value = "文件上传以及管理")
@RequestMapping("/files")
@RestController
public class FileUploadController {

    @Autowired
	private StorageService storageService;

    @ApiOperation(value = "查看文件列表", response = HttpResponse.class, produces = "application/json")
	@GetMapping("/list")
	public HttpResponseSingle listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> "/files/"+path.getFileName().toString())
				.collect(Collectors.toList()));
		return new HttpResponseSingle(CONSTLIST.OK,"success",model);
	}

    @ApiOperation(value = "获取指定文件", response = HttpResponse.class, produces = "application/json")
	@GetMapping("/{filename:.+}")
	public ResponseEntity<Resource> serveFile(
            @ApiParam(value = "文件名称", required = true) @PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

    @ApiOperation(value = "上传文件", response = HttpResponse.class, produces = "application/json")
	@PostMapping("/upload")
	public HttpResponseSingle handleFileUpload(
            @ApiParam(example = "file",value = "要上传的文件", required = true)@RequestParam("file") MultipartFile file) {

		String filename = storageService.store(file);
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
        if (filename != null){
            return new HttpResponseSingle(CONSTLIST.OK,"success", filename);
        } else {
            throw new StorageException("file upload failed");
        }

	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
