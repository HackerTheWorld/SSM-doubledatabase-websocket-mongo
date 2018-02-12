package com.cn.hnust.pojo;

public class VoyageEntity {

	private Integer voyage_id;
	private String voyage_num;
	private String voyage_models;
	private String get_box_address;
	private String in_return_box;
	private Integer take_user_id;
	private String imgname;

	public Integer getVoyage_id() {
		return voyage_id;
	}

	public void setVoyage_id(Integer voyage_id) {
		this.voyage_id = voyage_id;
	}

	public String getVoyage_num() {
		return voyage_num;
	}

	public void setVoyage_num(String voyage_num) {
		this.voyage_num = voyage_num == null ? null : voyage_num.trim();
	}

	public String getVoyage_models() {
		return voyage_models;
	}

	public void setVoyage_models(String voyage_models) {
		this.voyage_models = voyage_models == null ? null : voyage_models.trim();
	}

	public String getGet_box_address() {
		return get_box_address;
	}

	public void setGet_box_address(String get_box_address) {
		this.get_box_address = get_box_address == null ? null : get_box_address.trim();
	}

	public String getIn_return_box() {
		return in_return_box;
	}

	public void setIn_return_box(String in_return_box) {
		this.in_return_box = in_return_box == null ? null : in_return_box.trim();
	}

	public Integer getTake_user_id() {
		return take_user_id;
	}

	public void setTake_user_id(Integer take_user_id) {
		this.take_user_id = take_user_id;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname == null ? null : imgname.trim();
	}
}