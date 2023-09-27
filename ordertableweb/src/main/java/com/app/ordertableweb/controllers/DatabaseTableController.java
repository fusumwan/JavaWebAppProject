package com.app.ordertableweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.ordertableweb.domain.models.data.TableFieldCollection;
import com.app.ordertableweb.domain.services.DatabaseTableService;
import com.app.ordertableweb.domain.utils.JsonUtil;


/*
 * http://localhost:8080/genbook/databasetable/tablefield
 * */

@Controller
@RequestMapping("/databasetable")
public class DatabaseTableController {
	@Autowired
	private DatabaseTableService databaseTableService;
	
	@RequestMapping(value = "/tablefield", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> getTableField(@RequestParam(value="tableName", required = false) String tableName){
		TableFieldCollection tableFieldCollection=databaseTableService.getTableFieldType("MYSQL",tableName);
		String Json=JsonUtil.ToJson(tableFieldCollection.getFields());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(Json,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/postFormFieldInputTypes", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> postFormFieldInputTypes(@RequestParam(value="tableName", required = true) String tableName){
		TableFieldCollection tableFieldCollection=databaseTableService.getTableFieldType("MYSQL",tableName);
		String Json=JsonUtil.ToJson(tableFieldCollection.getFields());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(Json,headers,HttpStatus.OK);
	}
	//http://localhost:8080/databasetable/getFormFieldInputTypes?tableName=book
	@RequestMapping(value = "/getFormFieldInputTypes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getFormFieldInputTypes(@RequestParam(value="tableName", required = true) String tableName){
		TableFieldCollection tableFieldCollection=databaseTableService.getTableFieldType("MYSQL",tableName);
		String Json=JsonUtil.ToJson(tableFieldCollection.getFields());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(Json,headers,HttpStatus.OK);
	}
}
