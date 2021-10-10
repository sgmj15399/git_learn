/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.transaction.demo.service.impl;

import com.account.demo.entity.Account;
import com.account.demo.service.AccountService;
import com.transaction.demo.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author minjian
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    final private AccountService accountService;

    /**
     * 注入
     * @param accountService
     */
    @Autowired(required = false)
    public TransactionServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void transaction() {
        transactionA();
        transactionB();
    }

    private void transactionA() {
        log.info("============py one dubbo try 执行确认付款接口===============");
        Account account = new Account();
        account.setId(1L);
        account.setUs_wallet(-1L);
        account.setCny_wallet(7L);
        accountService.pay(account);
    }

    private void transactionB() {
        log.info("============py two dubbo try 执行确认付款接口===============");
        Account account = new Account();
        account.setId(2L);
        account.setUs_wallet(1L);
        account.setCny_wallet(-7L);
        accountService.pay(account);
    }

}
