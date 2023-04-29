/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;

import DAO.taikhoanDAO;
import DTO.adminDTO;

public class adminBUS {
	private ArrayList<adminDTO> list_admin;
	private taikhoanDAO adDAL;

	public void docDB() throws Exception {
		list_admin = new ArrayList<>();
		adDAL = new taikhoanDAO();
		list_admin = adDAL.docDB(null,null);
	}

	public adminBUS() throws Exception {
		list_admin = new ArrayList<>();
		adDAL = new taikhoanDAO();
		list_admin = adDAL.docDB(null,null);
	}
	public Boolean kiemTraDangNhap(adminDTO tk) {
		for (adminDTO taikhoan : list_admin) {
			// kiểm tra mật khảu và tên đăng nhập
			if (taikhoan.getAdminUser().equalsIgnoreCase(tk.getAdminUser())
					&& taikhoan.getAdminPass().equalsIgnoreCase(tk.getAdminPass())) {
				return true;
			}
		}
		return false;
	}
}
