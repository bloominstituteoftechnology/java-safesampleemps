package com.lambdaschool.sampleemps.services;

import com.lambdaschool.sampleemps.models.JobTitle;

public interface JobTitleService
{
    JobTitle update(
        long id,
        JobTitle jt);
}
