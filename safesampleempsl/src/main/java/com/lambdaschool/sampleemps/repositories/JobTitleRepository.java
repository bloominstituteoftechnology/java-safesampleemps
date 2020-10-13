package com.lambdaschool.sampleemps.repositories;

import com.lambdaschool.sampleemps.models.JobTitle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface JobTitleRepository
    extends CrudRepository<JobTitle, Long>
{
    @Transactional
    @Modifying
    @Query(value = "UPDATE jobtitles SET title = :title, last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP WHERE jobtitleid = :jobtitleid",
        nativeQuery = true)
    void updateJobTitle(
        String uname,
        long jobtitleid,
        String title);
}
