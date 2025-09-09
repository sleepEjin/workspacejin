package com.kh.example.gearrent;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
	private String itemId;
	private String memberId;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	public Loan(String itemId, String memberId, LocalDate date, LocalDate date2) {
		super();
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = date;
		this.dueDate = date2;
	}
	
	public boolean isOverdue(LocalDate today) {
		
		//계산기준일(반납날짜 또는 오늘)
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		//기준일이 마감일(dueDate)보다 늦으면 연체 발생
		return day.isAfter(dueDate);
	}
	
	public int overdueDays(LocalDate today) {
		//계산기준일(반납날짜 또는 오늘)
		LocalDate day = (returnedDate != null) ? returnedDate : today;
		
		if(day.isAfter(dueDate)) {
			long days = ChronoUnit.DAYS.between(dueDate, day);
			
			return (int)Math.abs(days);
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "Loan [itemId=" + itemId + ", memberId=" + memberId + ", loanDate=" + loanDate + ", dueDate=" + dueDate
				+ ", ret=" + returnedDate + "]";
	}

}
