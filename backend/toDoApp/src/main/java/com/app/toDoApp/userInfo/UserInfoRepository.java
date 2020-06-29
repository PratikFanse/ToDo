package com.app.toDoApp.userInfo;

import com.app.toDoApp.admin.graphReport.GraphData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    @Query("from UserInfo where role='user'")
    List<UserInfo> findAllUsers();

//    @Query("from UserInfo where regdate>=curdate()-7 order by regdate")
//    List<UserInfo> getRegisterUser(Date date);
//



//    @Query("SELECT username, userid, count(taskid) as count FROM UserInfo as uf join task t on userid = id")
//    List<TaskCount> get ();

}
