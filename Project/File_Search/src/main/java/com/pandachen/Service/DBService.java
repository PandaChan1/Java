package com.pandachen.Service;

import com.pandachen.DAO.InitDAO;

public class DBService {
        private final InitDAO initDAO = new InitDAO();
        public void init() {
            initDAO.init();
        }
}
