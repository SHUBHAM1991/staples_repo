package com.staples.salesattribution.dao;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class SalesAttribStoredProcecureTasklet implements Tasklet{
	private String sql;
	private DataSource dataSource;	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		JdbcTemplate myJDBC=new JdbcTemplate(getDataSource());
        myJDBC.execute(sql);
        return RepeatStatus.FINISHED;
	}

	private DataSource getDataSource() {
		return dataSource;
	}    


}
