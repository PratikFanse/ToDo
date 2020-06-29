package com.app.toDoApp.admin.graphReport;

import com.app.toDoApp.admin.graphReport.GraphData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphReportRepository extends JpaRepository<GraphData, Integer> {

    @Query("from GraphData where date>=curdate()-7 order by date")
    List<GraphData> getGraphData();

    GraphData findByDate(String date);

}
