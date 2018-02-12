package com.cn.hnust.pojo;

public class OlderEntity {

	private Integer kuaidi_id;
	private String kuaidi_num;
	private String getorder_num;
	private String phone;
	private String person;
	private String make_box_time;
	private String order_num;
	private Integer take_user_id;
	private Double number;
	private Double v;
	private Integer voyage_id;
	private Double weight;
	private String make_box_address;
	private Integer type;

	public Integer getKuaidi_id() {
		return kuaidi_id;
	}

	public void setKuaidi_id(Integer kuaidi_id) {
		this.kuaidi_id = kuaidi_id;
	}

	public String getKuaidi_num() {
		return kuaidi_num;
	}

	public void setKuaidi_num(String kuaidi_num) {
		this.kuaidi_num = kuaidi_num == null ? null : kuaidi_num.trim();
	}

	public String getGetorder_num() {
		return getorder_num;
	}

	public void setGetorder_num(String getorder_num) {
		this.getorder_num = getorder_num == null ? null : getorder_num.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person == null ? null : person.trim();
	}

	public String getMake_box_time() {
		return make_box_time;
	}

	public void setMake_box_time(String make_box_time) {
		this.make_box_time = make_box_time == null ? null : make_box_time.trim();
	}

	public String getOrder_num() {
		return order_num;
	}

	public void setOrder_num(String order_num) {
		this.order_num = order_num == null ? null : order_num.trim();
	}

	public Integer getTake_user_id() {
		return take_user_id;
	}

	public void setTake_user_id(Integer take_user_id) {
		this.take_user_id = take_user_id;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getV() {
		return v;
	}

	public void setV(Double v) {
		this.v = v;
	}

	public Integer getVoyage_id() {
		return voyage_id;
	}

	public void setVoyage_id(Integer voyage_id) {
		this.voyage_id = voyage_id;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getMake_box_address() {
		return make_box_address;
	}

	public void setMake_box_address(String make_box_address) {
		this.make_box_address = make_box_address == null ? null : make_box_address.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}