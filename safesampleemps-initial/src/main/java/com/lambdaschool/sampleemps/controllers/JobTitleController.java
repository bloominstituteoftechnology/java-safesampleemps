package com.lambdaschool.sampleemps.controllers;

import com.lambdaschool.sampleemps.models.JobTitle;
import com.lambdaschool.sampleemps.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/jobtitles")
public class JobTitleController
{
    @Autowired
    JobTitleService jtService;

    @PutMapping(value = "/jobtitle/{jobtitleid}",
            consumes = {"application/json"})
    public ResponseEntity<?> putUpdateJobTitle(
            @PathVariable
                    long jobtitleid,
            @Valid
            @RequestBody
                    JobTitle newJT)
    {
        newJT = jtService.update(jobtitleid,
                                 newJT);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping(value = "/jobtitle/{jobtitlesid}",
            consumes = {"application/json"})
    public ResponseEntity<?> patchUpdateJobTitle(
            @PathVariable
                    long jobtitlesid,
            @RequestBody
                    JobTitle newJT)
    {
        newJT = jtService.update(jobtitlesid,
                                 newJT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
