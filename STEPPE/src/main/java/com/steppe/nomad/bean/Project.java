package com.steppe.nomad.bean;

public class Project {
	private String p_num; //프로젝트 번호
	private int p_pc1id; //1차 카테고리 아이디
	private int p_pc2id; //2차 카테고리 아이디
	private String p_mid; //회원 아이디
	private int p_budget; //프로젝트 예산
	private String p_term; //프로젝트 기간
	private String p_title; //프로젝트 제목
	private String p_content; //프로젝트 내용
	private String p_filename; //프로젝트 첨부파일
	private String p_deadline; //프로젝트 마감일
	private String p_plnum; //프로젝트 필요 언어
	private int p_person; //프로젝트 인원
	private int p_status; //프로젝트 상태
	
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public int getP_pc1id() {
		return p_pc1id;
	}
	public void setP_pc1id(int p_pc1id) {
		this.p_pc1id = p_pc1id;
	}
	public int getP_pc2id() {
		return p_pc2id;
	}
	public void setP_pc2id(int p_pc2id) {
		this.p_pc2id = p_pc2id;
	}
	public String getP_mid() {
		return p_mid;
	}
	public void setP_mid(String p_mid) {
		this.p_mid = p_mid;
	}
	public int getP_budget() {
		return p_budget;
	}
	public void setP_budget(int p_budget) {
		this.p_budget = p_budget;
	}
	public String getP_term() {
		return p_term;
	}
	public void setP_term(String p_term) {
		this.p_term = p_term;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public String getP_filename() {
		return p_filename;
	}
	public void setP_filename(String p_filename) {
		this.p_filename = p_filename;
	}
	public String getP_deadline() {
		return p_deadline;
	}
	public void setP_deadline(String p_deadline) {
		this.p_deadline = p_deadline;
	}
	public String getP_plnum() {
		return p_plnum;
	}
	public void setP_plnum(String p_plnum) {
		this.p_plnum = p_plnum;
	}
	public int getP_person() {
		return p_person;
	}
	public void setP_person(int p_person) {
		this.p_person = p_person;
	}
	public int getP_status() {
		return p_status;
	}
	public void setP_status(int p_status) {
		this.p_status = p_status;
	}
	
}
