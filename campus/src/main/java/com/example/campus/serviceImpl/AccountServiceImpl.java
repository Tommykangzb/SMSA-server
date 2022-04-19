package com.example.campus.serviceImpl;

import com.example.campus.dao.AccountDAO;
import com.example.campus.service.AccountService;
import com.example.campus.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired(required = false)
    AccountDAO accountDAO;

    @Transactional
    public Account getByAccount_numAndPassword(String account_num, String password) {
        try {
            return accountDAO.getByAccount_numAndPassword(account_num, password);
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Boolean addAccount(String account_num, String password, String teacher_id, String teacher_name) {
        try {
            if (account_num.length() == 12 && password.length() <= 20 && teacher_id.length() == 12 && teacher_name.length() <= 20) {
                int count = accountDAO.insertAccount(account_num, password, teacher_id, teacher_name);
                if (count > 0) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Boolean deleteAccount(String account_num) {
        try {
            String teacher_id = accountDAO.getTeacher_idByAccount_num(account_num);
            int count = accountDAO.deleteAccount(account_num, teacher_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Boolean setTeacherClass(String account_num, String class_id) {
        try {
            String teacher_id = accountDAO.getTeacher_idByAccount_num(account_num);
            int count = accountDAO.setTeacherClass(teacher_id, class_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }

    }

    @Transactional
    public Boolean setHeadTeacher(String account_num, String class_id) {
        try {
            int count = accountDAO.setHeadTeacher(account_num, class_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }

    }

    @Transactional
    public Boolean cancelTeacherClass(String account_num, String class_id) {
        try {
            String teacher_id = accountDAO.getTeacher_idByAccount_num(account_num);
            int count = accountDAO.cancelTeacherClass(teacher_id, class_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }

    }

    @Transactional
    public Boolean cancelHeadTeacher(String account_num, String class_id) {
        try {
            int count = accountDAO.cancelHeadTeacher(account_num, class_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Account getAccountInfo(String account_num) {
        try {
            return accountDAO.getAccountInfo(account_num);
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public List<Account> getAllAccount() {
        try {
            List<Account> accountList = accountDAO.getAllAccount();
            return accountList;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Boolean addClass(String class_id, int grade) {
        try {
            if (class_id.length() == 6 && (grade + "").length() == 4) {
                int count = accountDAO.insertClass(class_id, grade);
                if (count > 0) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    public Boolean deleteClass(String class_id) {
        try {
            int count = accountDAO.deleteClass(class_id);
            if (count > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }

    }
}
