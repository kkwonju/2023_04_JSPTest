import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();
		
		while(true){
			System.out.print("명령어 : ");
			String cmd = sc.nextLine().trim();
			
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("article write")) {
				int id = lastArticleId + 1;
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				String redDate = "12-12-12 12:12:12";
				
				Article article = new Article(id, redDate, title, body);
				articles.add(article);
				lastArticleId++;
				System.out.println(id + "번 글 생성");
				
			} else if(cmd.equals("article list")) {
				if(articles.size() == 0) {
					System.out.println("게시글 없음");
					continue;
				}
				System.out.println("번호   /   제목");
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					System.out.println("번호 : " + article.id);
					System.out.println("작성일 : " + article.regDate);
					System.out.println("제목 : " + article.title);
					System.out.println("내용 : " + article.body);
				}
			} else {
				System.out.println("명령어를 확인해주세요");
				continue;
			}
		}
		System.out.println("==프로그램 종료==");
		sc.close();
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;
	
	public Article(int id, String redDate, String title, String body) {
		this.id = id;
		this.regDate = redDate;
		this.title = title;
		this.body = body;
	}
}