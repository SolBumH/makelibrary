package com.library.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.dto.BookDTO;

public class test {

  public static void main(String[] args) {

    String shoppingJson = "{ \"lastBuildDate\":\"Tue 30 Jan 2024 16:39:58 +0900\" \"total\":546 \"start\":1 \"display\":10 \"items\":[ { \"title\":\"이펙티브 자바 (프로그래밍인사이트)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/32436239326\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3243623\\/32436239326.20230919125641.jpg\" \"author\":\"조슈아 블로크\" \"discount\":\"30780\" \"publisher\":\"인사이트\" \"pubdate\":\"20181101\" \"isbn\":\"9788966262281\" \"description\":\"자바 플랫폼 모범 사례 완벽 가이드 - Java 7 8 9 대응\\n\\n자바 6 출시 직후 출간된 『이펙티브 자바 2판』 이후로 자바는 커다란 변화를 겪었다. 그래서 졸트상에 빛나는 이 책도 자바 언어와 라이브러리의 최신 기능을 십분 활용하도록 내용 전반을 철저히 다시 썼다. 모던 자바가 여러 패러다임을 지원하기 시작하면서 자바 개발자들에게는 구체적인 모범 사례가 더욱 절실해졌고 관련 조언을 이 책에 담아낸 것이다.\\n \\n3판에는 자바 7 8 9에서 자바 언어와 라이브러리에 추가된 특성들을 녹여냈다. 특히 그동안 객체 지향에 치중하던 자바에 새로 도입된 함수형 프로그래밍 요소도 자세히 알아본다. 람다(lambda)와 스트림(stream)만을 다룬 장을 포함하여 새로운 아이템도 많이 추가되었다.\\n \\n새롭게 다루는 주제들\\n-\\t함수형 인터페이스 람다식 메서드 참조 스트림\\n-\\t인터페이스의 디폴트 메서드와 정적 메서드\\n-\\t제네릭 타입에서의 다이아몬드 연산자를 포함한 타입 추론\\n-\\t@SafeVarargs 애너테이션\\n-\\ttry-with-resources 문\\n-\\tOptional T 인터페이스 java.time 컬렉션의 편의 팩터리 메서드 등의 새로운 라이브러리 기능\" } { \"title\":\"You Don’t Know JS Yet (자바스크립트 개념 스코프와 클로저)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/45009754619\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_4500975\\/45009754619.20240106070806.jpg\" \"author\":\"카일 심슨\" \"discount\":\"25650\" \"publisher\":\"한빛미디어\" \"pubdate\":\"20240112\" \"isbn\":\"9791169211888\" \"description\":\"당신은 아직 자바스크립트를 모른다!\\n더욱 깊이 제대로 이해하는 자바스크립트 핵심 개념\\n\\n세계적으로 베스트셀러가 된 『You Don't Know JS』 시리즈가 2판으로 돌아왔습니다. 2판은 자바스크립트의 모든 측면을 다루고 유용한 정보를 제공하기 위해 완전히 새롭게 작성되었습니다. 이 책은 자바스크립트 핵심 개념을 깊이 다루며 유용한 코드 패턴도 소개합니다. 또한 자바스크립트를 학습하면서 생기는 다양한 의문을 저자 특유의 독특한 시각과 재치 있는 설명으로 탐구합니다. \\n\\n이 책은 『You Don't Know JS Yet』 시리즈의 첫 번째 책인 ‘시작하기’와 두 번째 책인 ‘스코프와 클로저’를 한 권으로 엮었습니다. 자바스크립트의 핵심 개념을 이해하고자 하는 분들에게 완벽한 가이드가 될 것이며 더 깊이 파고들고 싶은 개발자에게 매우 유용할 것입니다. 여러분의 개발 실력을 한 단계 높여줄 완벽한 가이드를 손에 들고 흥미로운 자바스크립트 여정을 떠날 차례입니다.\" } { \"title\":\"자바의 꿈 (이태복 시집)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/32466841922\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3246684\\/32466841922.20221227203319.jpg\" \"author\":\"이태복\" \"discount\":\"8100\" \"publisher\":\"시산맥사\" \"pubdate\":\"20190718\" \"isbn\":\"9791162430675\" \"description\":\"이태복 시인은 “정들어 고향이 된 자바 땅에”(「적도 나무꾼 일기」) 둥지를 틀고 하늘의 별자리를 바라보고 마을의 전설을 듣는다. 자바 아이들의 고무줄놀이를 구경하고 가믈란 음악을 듣고 오래 익은 술 같은 이웃들과 함께 살아간다. 일제가 식민지 여성들을 위안부로 짓밟은 역사를 암바라와 위안소에서 확인하며 일찍이 박인환 시인이 조선과 인도네시아 민중들에게 제국주의 국가들에 맞서 “최후의 한 사람까지 싸”(박인환 「인도네시아 인민에게 주는 시」)우자고 촉구한 목소리도 새긴다. 결국 이태복 시인은 자연에 겸손하고 사람들과 나눌 줄 알고 역사의식을 가질 때 인간은 행복할 수 있음을 일깨워준다. “돈의 종”(「살라띠가의 가을」)에서 벗어나 “달려도 달려도 끝없는\\/누런 들녘”(「1월 자바 들녘」)에서 민들레 같은 농부로 피었다 지는 꿈을 가지고 있는 시인은 한없이 행복하다. “호야불로 작은 등대를 세우고\\/희망의 심지를 돋”(「살라띠가의 호야불」)우는 하루하루가 자바 사람들의 미소처럼 밝은 것이다. \\n\\n-맹문재(시인 안양대 교수)\" } { \"title\":\"자바 (Seventh Edition)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/32467024674\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3246702\\/32467024674.20221019150629.jpg\" \"author\":\"Horstmann Cay S.\" \"discount\":\"31500\" \"publisher\":\"한티미디어\" \"pubdate\":\"20140303\" \"isbn\":\"9788964211830\" \"description\":\"▶ 이 책은 자바를 다룬 이론서입니다. 자바의 기초적이고 전반적인 내용을 학습할 수 있도록 구성했습니다.\" } { \"title\":\"이것이 취업을 위한 백엔드 개발이다 with 자바 (취업과 이직을 결정하는 백엔드 과제 테스트+기술 면접 가이드)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/45070745618\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_4507074\\/45070745618.20240106090841.jpg\" \"author\":\"이준형\" \"discount\":\"30780\" \"publisher\":\"한빛미디어\" \"pubdate\":\"20240112\" \"isbn\":\"9791169211338\" \"description\":\"백엔드 개발자 취업 무엇을 어떻게 준비할까?\\n생생한 과제테스트 경험을 바탕으로 백엔드 개발자 취업의 모든 것을 배운다!\\n\\n백엔드 개발자를 꿈꾸는 분이라면 이런 이야기를 많이 들어 봤을 것입니다.\\n“백엔드 개발자가 되려면 자바로 웹 개발을 배워야 합니다.”\\n“백엔드 개발자가 되고 싶다면 스프링 프레임워크를 공부해야 합니다.”\\n틀린 말은 아니지만 이런 이야기를 듣는 사람 입장에서는 개발자가 되기 위한 공부 방향을 설정하\\n는 데 그다지 도움이 되지 않습니다.\\n자바 프로그래밍을 배웠지만 HTTP 기초도 알아야 하고 스프링 프레임워크 데이터베이스 등 어떤 것부터 시작해야 할지 막막합니다. 학습 수준의 차이는 있을지 모르지만 백엔드 개발자가 되기 위해서는 여러 주요한 학습의 키워드를 유기적으로 연결할 줄 알아야 합니다. 이 책은 ‘자바 프로그래밍에 대한 기초 지식이 있는 사람이 빠르게 자바 웹 개발에 입문하고 간단한 과제 테스트를 풀이할 수 있으려면 어떻게 학습해야 할까?’라는 물음에서 시작됐습니다.\\n\\nPART 01~02에서는 백엔드 개발자 채용 프로세스부터 실무에서 가장 많이 사용하는 자바 문법 백엔드 개발을 위한 서버와 클라이언트의 구조 등 필수 기본 지식을 다루고 PART 03~04에서는 과제 테스트를 위한 백엔드 애플리케이션 개발의 과정을 친절하게 설명합니다.\\n『이것이 취업을 위한 백엔드 개발이다 with 자바』를 통해 실제 백엔드 개발자 채용 과정에서 출제되는 다양한 과제 테스트를 해결하며 실무 역량을 발휘할 밑거름을 마련해 보세요!\" } { \"title\":\"자바스크립트 (최고의 강의를 책으로 만나다)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/45349267640\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_4534926\\/45349267640.20240120153715.jpg\" \"author\":\"곽문기\" \"discount\":\"28800\" \"publisher\":\"생능북스\" \"pubdate\":\"20240125\" \"isbn\":\"9791192932477\" \"description\":\"간단한 코딩으로\\n자바스크립트 실력을 빌드업하자!\\n\\n이 책은 웹 개발을 처음 시작하거나 관심이 있는 모두를 대상으로 쓰여졌습니다. 웹페이지의 효율적인 작성을 위해 웹 표준의 이해와 설명을 시작으로 책의 핵심 내용인 자바스크립트의 쓰임과 활용 그리고 다양한 응용과 기술적인 트렌드까지 살펴볼 수 있도록 구성하였습니다. \\n\\n또한 웹페이지 작성을 위해 넓은 범위에서 전략적인 이해와 기술적인 세밀한 이야기를 함께 담으려고 노력하였습니다. 특히 핵심이 되는 용어는 가급적 쉽게 풀어 바로 이해될 수 있도록 하였습니다. \\n\\n저자 깃허브 : https:\\/\\/github.com\\/kwakmoonki\\/booksr\\/\" } { \"title\":\"자바시장\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/33435744838\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3343574\\/33435744838.20221019152940.jpg\" \"author\":\"박계상\" \"discount\":\"11700\" \"publisher\":\"푸른사상\" \"pubdate\":\"20090930\" \"isbn\":\"9788956407159\" \"description\":\"한국인들의 미국의류시장 개척기 자바시장. 조국을 떠난다는 것. 그곳에서 살아간다는 것. 흔한 듯 흔하지 않은 이민세대들의 이야기. ‘자바시장’은 그 이야기를 하고 있다. 이민자이기 때문에 느낄 수밖에 없는 향수 한국인이기 때문에 당할 수밖에 없었던 차별. 그러한 고난의 시간 속에서 LA에 한인 타운을 구축한 한국인들. 나아가 미국의 의류산업에까지 영향을 미칠 수 있는 자바시장을 이룩해낸 한국인들의 자랑스러운 모습을 작가는 가슴 뭉클하게 그려내고 있다. \\n\\n\\n\\n조국을 떠나 새로운 삶의 터전을 맨몸으로 일구어내야 했던 이민자들. 힘겨운 시간을 이겨내고 힘껏 뿌리박은 한인들의 모습을 생동감 있고 또 사실감 있게 그릴 수 있었던 것은 작가가 그들의 곁에서 그들과 함께 호흡하고 생활한 결과물이다. 멀리 떨어져 있는 것으로만 여겼던 그래서 다르다고만 생각했던 아득한 그들의 이야기를 우리 눈앞에 생생하게 보여주는 것. 그것이 '자바시장'이다.\" } { \"title\":\"오쿠자바의 노래시\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/35303027404\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3530302\\/35303027404.20231115072138.jpg\" \"author\":\"불라트 오쿠자바\" \"discount\":\"10800\" \"publisher\":\"지식을만드는지식(지만지)\" \"pubdate\":\"20100915\" \"isbn\":\"9788964065877\" \"description\":\"러시아 음유시의 대가 오쿠자바 \\n그의 따스한 목소리를 듣는다. \\n오쿠자바는 러시아 현대 문학에서 손꼽히는 시인으로 음유시가의 전통을 계승했다고 평가받는다. 자신의 시에 직접 곡을 붙이고 기타 반주를 하며 대중 앞에서 노래하는 것을 즐겨해 그의 작품들을 노래시라고 부른다. 독자들에게 오쿠자바 노래시의 진면목을 알리기 위해 악보를 함께 실었다. 아르바트 거리와 사랑에 대한 예찬 전쟁에 대한 비판 등 따뜻한 인간애를 바탕으로 한 그의 나직한 목소리는 신산한 삶의 고통을 위로하는 힘을 지녔다.\" } { \"title\":\"헤드퍼스트 자바 (자바로 여는 무한한 객체지향의 세계!)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/44887328627\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_4488732\\/44887328627.20231228072151.jpg\" \"author\":\"캐시 시에라^버트 베이츠^트리샤 지\" \"discount\":\"35910\" \"publisher\":\"한빛미디어\" \"pubdate\":\"20240102\" \"isbn\":\"9791169211796\" \"description\":\"두뇌를 자극하며 한 걸음씩 배우는 자바 학습법\\n친절한 설명과 실전 예제로 직접 체험하며 배우는 자바 프로그래밍\\n\\n하나 〈헤드 퍼스트〉 시리즈만의 다채로운 구성으로 자바를 쉽고 재미있게 배울 수 있습니다.\\n글로만 가득 차 있는 두꺼운 자바 학습서에 지치셨나요? 『헤드 퍼스트 자바(3판)』는 〈헤드 퍼스트〉 시리즈의 특징인 친근한 대화체 스타일과 풍부한 시각 자료 텍스트와 이미지를 함께 활용하여 뇌를 자극하는 학습법을 제안합니다. 각종 비유와 등장인물의 이야기를 따라가다 보면 어느새 자바에 대한 지식이 그림처럼 머릿속에 생생하게 새겨집니다.\\n\\n둘 개념을 이해하는 것을 넘어서 현업에서 활용할 수 있는 실전 능력을 기를 수 있습니다.\\n자바의 기초부터 심화 개념까지 모든 것을 상세하게 설명하고 다양한 실전 예제를 바탕으로 실제 활용까지 나아갈 수 있는 실용적인 학습을 지향합니다. 단순히 개념을 설명하는 데 그치지 않고 자바를 사용하는 개발자들이 흔히 저지르는 실수 자주 묻는 질문과 답변 전문가의 친절한 조언 등을 바탕으로 실무 활용 능력을 극대화할 수 있습니다.\\n\\n셋 자바 버전 업데이트에 따른 개정 내용을 대응합니다.\\n개정판 이후로 자바 버전 업데이트에 따른 내용을 보완하고 예제 코드와 부가 설명을 새 버전에 맞춰 수정하였습니다. 또한 원서의 내용을 정확하게 반영하되 새로운 삽화를 더해 한국어판만의 맛을 살렸습니다. 『헤드 퍼스트 자바(3판)』 한 권이면 초보자부터 개발자까지 쉽고 편안하게 최신 버전의 자바를 배울 수 있습니다.\" } { \"title\":\"내가 글자 바보라고? (난독증인 종이접기 천재)\" \"link\":\"https:\\/\\/search.shopping.naver.com\\/book\\/catalog\\/39183796620\" \"image\":\"https:\\/\\/shopping-phinf.pstatic.net\\/main_3918379\\/39183796620.20230926084842.jpg\" \"author\":\"공윤경\" \"discount\":\"11120\" \"publisher\":\"내일을여는책\" \"pubdate\":\"20230404\" \"isbn\":\"9788977469945\" \"description\":\"우리가 모두 함께 고민하고 생각해 볼 문제를 재밌는 동화로 풀어내는 ‘내일을여는어린이’ 시리즈의 서른네 번째 책 난독증이라는 장애 그리고 다른 이의 약점을 대하는 우리의 모습에 관한 책이다. \\n작품 속 주인공은 난독증이라는 장애가 있다. 난독증의 정식 명칭은 ‘음운 인식 장애’다. 글자를 읽고 쓰는 뇌의 기능이 제대로 작동하지 않으면서 생기는 장애이다. 그래서 일반 사람에게는 아무것도 아닌 글자를 읽고 쓰는 일이 주인공 하민이와 같은 이들에게는 너무나 어렵고 힘든 일이다. \\n\\n☐ 작품 내용\\n하민이는 초등학생이다. 글자를 읽고 쓰고 배우고 공부해야 할 때지만 하민이는 그게 너무 싫다. 글자가 너무너무 싫다. 왜냐하면 난독증이기 때문이다. ‘음운 인식 장애’란다. 하민이는 답답하고 억울하다. 하기 싫어서 안 하는 게 아닌데 글자들이 자꾸 날아가 버리고 돌아가 버리고 바뀌어 버리는데 어떡하라고. 왜 나만 이런 약점이 있을까 하민이는 너무나 힘들다.\\n결국 친구들에게 약점을 들키고 싶지 않아 자꾸만 자신을 숨긴다. 숨기는 방법은 간단하다. 아무것도 하지 않는 것. 친구들과 사귀지도 않고 발표도 하지 않고. 그리고 자신이 잘하는 것 종이접기에 몰두한다. 바로 유튜버 ‘지니핑거’! 영상 속 지니핑거는 현란한 손기술로 새로운 것들을 접어 낸다. 하민이는 지니핑거일 때는 자신감이 넘친다. \\n문득 하민이는 자신이 접은 카멜레온을 보며 생각한다. 세상에 자신의 약점을 드러내지 않기 위해 몸을 숨기는 카멜레온과 자신이 닮았다고. 그리고 또 단짝 친구 지안이를 보며 생각한다. 몸집이 작고 축구도 못하는 지안이가 툭하면 성질을 내고 친구들을 괴롭히는 모습을 보며 약한 자신을 숨기려고 목 주위를 부풀려 다른 이들을 위협하는 목도리도마뱀 같다고. \\n지안이의 생일 파티 날. 자신은 난독증이고 유튜버 지니핑거라고 고백하려고 마음 먹은 날이었지만 하필 이름이 너무 어려운 ‘킹콩점핑 키즈 카페’를 제대로 찾지 못해 계획을 모두 망쳐 버렸다. 자꾸만 지안이와 멀어져 버린다. 왜 이렇게까지 되어 버렸지? 하민이는 더이상 지안이와 멀어지고 싶지 않다. 각자의 약점 때문에 진짜 모습을 보이지 못하는 하민이와 지안이가 다시 우정을 되찾을 수 있을까?\" } ]}";

    List<BookDTO> resultList = new ArrayList<>();

    String[] passingSplit = shoppingJson.split("\"items\":\\[ \\{"); // 앞 잉여데이터 삭제
    passingSplit = passingSplit[1].split(" } ]}"); // 뒤 잉여데이터 삭제
//          System.out.println(Arrays.toString(passingSplit));
    passingSplit = passingSplit[0].split("}"); // 각 아이템별로 데이터 나누기
//          System.out.println(Arrays.toString(passingSplit));

//          System.out.println("-----------------------------");

    for (int i = 0; i < passingSplit.length; i++) {
      passingSplit[i] = passingSplit[i].replace(",{", "").replace("{", ""); // 괄호 삭제
//              System.out.println(Arrays.toString(passingSplit));
    }
    String[][] rowDataArr = new String[passingSplit.length][]; // ROW데이터를 담기위한 2차원 배열
    for (int i = 0; i < passingSplit.length; i++) {
      rowDataArr[i] = passingSplit[i].split("\",\""); // 따움표 삭제
      for (int j = 0; j < rowDataArr[i].length; j++) {
        rowDataArr[i][j] = rowDataArr[i][j].replaceAll("<b>", "").replaceAll("</b>", "") // DB에 담을 값에서 필요 없는
            // HTML 삭제
            .replaceAll("&quot;", "").strip(); // 필요없는 코드 및 앞 뒤 공백 삭제
      }
    }
    System.out.println("-----------------------");
//          System.out.println(rowDataArr.length + " : " + rowDataArr[0].length);
//          for (String[] s : rowDataArr) {
//              for (String ss: s) {
//                  System.out.println(ss);
//              }
//          }
    System.out.println("------------------");
//          System.out.println(rowDataArr[1][0]);

    List<Map<String, String>> jsonList = new ArrayList<>(); // ROW데이터로 분리될 객체MAP을 담을 LIST

    for (int i = 0; i < rowDataArr.length; i++) {
      Map<String, String> bookMap = new HashMap<>(); // ROW데이터를 분리할 맵
      String[] rowDataInfo = rowDataArr[i][0].split("\" \""); // :로만 나누면 엉뚱하게 나눠지는 내용도 있어 ": 로 스플릿
      for (int j = 0; j < rowDataInfo.length; j++) {
//                  System.out.println(rowDataInfo[j]);
        String[] rowDataInfo2 = rowDataInfo[j].split("\":\"");
//                  System.out.println("1 : " + rowDataInfo2[0].replaceAll("\"", ""));
//                  System.out.println("2 : " + rowDataInfo2[1]);
        bookMap.put(rowDataInfo2[0].replaceAll("\"", ""), rowDataInfo2[1].replaceAll("\"", ""));
        // 값에서
        // 따움표
        // 삭제 .strip()
      }
      jsonList.add(bookMap);
    }

//          System.out.println(jsonList.get(0).get("title"));
    for (int i = 0; i < jsonList.size(); i++) {
      System.out.println(jsonList.get(i));
    }

//      for (int i = 0; i < jsonList.size(); i++) {
    //
//          String title = jsonList.get(i).get("title");
//          String link = jsonList.get(i).get("link").replaceAll("gate.nhn\\?id\\=", "catalog/");
//          String image = jsonList.get(i).get("image");
//          String lprice = jsonList.get(i).get("lprice");
//          String hprice = jsonList.get(i).get("hprice");
//          String mallName = jsonList.get(i).get("mallName");
//          String productId = jsonList.get(i).get("productId");
//          String productType = jsonList.get(i).get("productType");
//          String maker = jsonList.get(i).get("maker");
//          String brand = jsonList.get(i).get("brand");
//          String category1 = jsonList.get(i).get("category1");
//          String category2 = jsonList.get(i).get("category2");
//          String category3 = jsonList.get(i).get("category3");
//          String category4 = jsonList.get(i).get("category4");
    //
//          ShoppingVO svo = new ShoppingVO(title, link, image, lprice, hprice, mallName, productId, productType, maker, brand, category1, category2, category3, category4);
    //
//          resultList.add(svo);
//      }
//          return resultList;
  }
}
