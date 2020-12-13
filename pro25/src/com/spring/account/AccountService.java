package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;

	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}

	public void sendMoney() throws Exception {
		//2개의 메서드가 하나의 트랜잭션
		accDAO.updateBalance1(); //출금
		accDAO.updateBalance2(); //증액
	}
}