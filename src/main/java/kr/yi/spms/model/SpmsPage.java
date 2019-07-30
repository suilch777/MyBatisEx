package kr.yi.spms.model;

import java.util.List;

import kr.yi.spms.model.Spms;

public class SpmsPage {
	
	private int total; //전체 게시판 글의 갯수
	private int currentPage; //현재 페이지 번호
	private List<Spms> content; //현재 화면에 display 될 게시판 리스트내용
	private int totalPages; //전체 페이지 수 
	private int startPage; //시작번호
	private int endPage; //끝번호
	private int pageSize = 10;//한 화면에 표시될 페이지 갯수
	
	// size: 한 페이지에 display될 게시글의 갯수
	public SpmsPage(int total, int currentPage, int size, List<Spms> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			// 123 : 13페이지
			totalPages = total / size; //123/10 = 12
			if(total % size > 0) {
				totalPages++; //13
			}
			//현제 페이지 번호가 12일 경우, modVal 2가 됨
			int modVal = currentPage % pageSize;
			// 12/10 = 1-> 1* 10 =10 -> 10 + 1 = 11
			startPage = currentPage / pageSize * pageSize + 1;
			
			// currentPage = 20, startPage = 21
			if(modVal == 0) { //현 페이지의 제일 마지막 번호인가?
				startPage -= pageSize; //시작 11
			}
			
			// 시작 페이지 11 : 끝 20
			endPage = startPage + (pageSize -1);
			
			//게시물읠 갯수 : 123, 총 페이지 번호 :13
			// start 11, endPage 20
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	
	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public List<Spms> getContent() {
		return content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	public boolean hasArticles() {
		return total > 0;
	}
	@Override
	public String toString() {
		return "SpmsPage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + ", pageSize=" + pageSize + "]";
	}

}
