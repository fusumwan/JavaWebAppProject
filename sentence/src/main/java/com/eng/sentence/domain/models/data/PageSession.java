package com.eng.sentence.domain.models.data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageSession implements java.io.Serializable {
	
	/*
	* If you want to make a List<Index> parameter for JSON serialization,
	* you need to making Index class static,
	* because by making the Index class static,
	* you have decoupled it from the enclosing PageSession class,
	* allowing it to be instantiated without a reference to a PageSession instance.
	*/
	public static class Index implements java.io.Serializable {
		
		
		@JsonProperty("search_criteria_1")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_1;
		
		@JsonProperty("search_criteria_2")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_2;
		
		@JsonProperty("search_criteria_3")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_3;
		
		
		public String getSearch_criteria_1() {
			return search_criteria_1;
		}
		
		public void setSearch_criteria_1(String search_criteria_1) {
			this.search_criteria_1 = search_criteria_1;
		}
		
		public String getSearch_criteria_2() {
			return search_criteria_2;
		}
		
		public void setSearch_criteria_2(String search_criteria_2) {
			this.search_criteria_2 = search_criteria_2;
		}
		
		public String getSearch_criteria_3() {
			return search_criteria_3;
		}
		
		public void setSearch_criteria_3(String search_criteria_3) {
			this.search_criteria_3 = search_criteria_3;
		}
		
	}
	
	/*
	* If you want to make a List<Result> parameter for JSON serialization,
	* you need to making Result class static,
	* because by making the Result class static,
	* you have decoupled it from the enclosing PageSession class,
	* allowing it to be instantiated without a reference to a PageSession instance.
	*/
	public static class Result implements java.io.Serializable {
		
		
		@JsonProperty("search_criteria_1")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_1;
		
		@JsonProperty("search_criteria_2")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_2;
		
		@JsonProperty("search_criteria_3")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String search_criteria_3;
		
		
		public String getSearch_criteria_1() {
			return search_criteria_1;
		}
		
		public void setSearch_criteria_1(String search_criteria_1) {
			this.search_criteria_1 = search_criteria_1;
		}
		
		public String getSearch_criteria_2() {
			return search_criteria_2;
		}
		
		public void setSearch_criteria_2(String search_criteria_2) {
			this.search_criteria_2 = search_criteria_2;
		}
		
		public String getSearch_criteria_3() {
			return search_criteria_3;
		}
		
		public void setSearch_criteria_3(String search_criteria_3) {
			this.search_criteria_3 = search_criteria_3;
		}
		
	}
	
	
	@JsonProperty("index")
	
	private Index index;
	
	@JsonProperty("login")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String login;
	
	@JsonProperty("signup")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String signup;
	
	@JsonProperty("accountInfo")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String accountInfo;
	
	@JsonProperty("result")
	
	private Result result;
	
	
	public Index getIndex() {
		return index;
	}
	
	public void setIndex(Index index) {
		this.index = index;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSignup() {
		return signup;
	}
	
	public void setSignup(String signup) {
		this.signup = signup;
	}
	
	public String getAccountinfo() {
		return accountInfo;
	}
	
	public void setAccountinfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void setResult(Result result) {
		this.result = result;
	}
	
}