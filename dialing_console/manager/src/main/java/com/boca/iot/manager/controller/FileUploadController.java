package com.boca.iot.manager.controller;


import com.boca.iot.manager.model.vo.common.Result;
import com.boca.iot.manager.model.vo.common.ResultCodeEnum;
import com.boca.iot.manager.service.FileUploadService;
import com.boca.iot.manager.utils.log.annotation.Log;
import com.boca.iot.manager.utils.log.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lulinwei
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/system")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService ;

    // <input type="file" name="file">
    @Log(title = "文件上传", businessType = BusinessType.DEFAULT)
    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/fileUpload")
    public Result<String> fileUploadService(@RequestParam(value = "file") MultipartFile multipartFile) {
        String fileUrl = fileUploadService.fileUpload(multipartFile) ;
        return Result.build(fileUrl , ResultCodeEnum.SUCCESS) ;
    }

}
