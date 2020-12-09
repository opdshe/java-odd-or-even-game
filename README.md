# 👨🏻‍💻 홀짝 게임
해당 프로그램은 사용자와 컴퓨터간의 홀짝 게임을 구현한 프로그램이다. 
<br>

## 🔮 기능 요구사항
- 상대방(컴퓨터)과 자신의 이름을 입력받는다
- 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 먼저 입력받는 이름이 상대방 이름
- 게임 진행 횟수를 입력받고, 해당 횟수만큼 게임을 진행한다
- 어느 한 쪽의 돈이 0이되면 게임이 종료된다
- 입력받은 횟수만큼 게임 진행 후 양쪽 다 자금이 남아있으면, 돈이 많이 남은 쪽이 승리한다
- 매 회마다 1-10 사이의 랜덤한 값이 생성된다. 
- 사용자는 원하는 금액만큼 배팅할 수 있고, 랜덤값의 홀/짝을 맞히면 해당 금액을 컴퓨터로부터 가져오고, 틀리면 컴퓨터에게 빼앗긴다
- 사용자는 게임 진행동안 단 한번 슈퍼배팅을 사용할 수 있다
  - 홀/짝이 아닌 랜덤값이 무엇인지 맞히면 상대방의 자금을 모두 가져올 수 있다
  - 틀리면 자금의 절반을 빼앗긴다
- 게임이 종료되면 최종 승자와 승자가 획득한 순 수익을 출력한다 

<br>

## 🍚 프로그래밍 요구사항
- **자바 8 기준으로 프로그래밍한다. (9이후에 새롭게 추가된 기능들을 사용할 수 없다.)**
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- **indent(인덴트, 들여쓰기) depth를 2 넘지 않도록 구현한다. 1까지만 허용한다.**
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.

### 추가된 요구사항
- 함수(또는 메소드)의 길이가 **10라인**을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Application
- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조와 구현은 변경하지 않는다.
- `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- `// TODO 구현 진행` 이 후 부터 구현한다.

```java
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
    }
}
```

### 프로그래밍 요구사항 - RandomUtils
- RandomUtils 클래스를 활용해 랜덤 기능을 구현해야 한다.
- RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

```java
private static final Random RANDOM = new Random();
    private RandomUtils() {
    }
    public static int nextInt(final int startInclusive, final int endInclusive) {
    ...
```
<br>


## 구현해야 할 기능 목록
- **상대방(컴퓨터)과 자신의 이름을 입력받는 기능**
  - 이름 양 끝에 트림 처리
  - 전체 공백 입력 시 예외 발생 ex) 엔터 입력
  - 부분 공백 입력 시 예외 발생 ex) 'fobi, ' 입력
  - 이름이 5글자 초과하면 예외 발생 ex) 'fobi, dongheon' 입력
  
- **게임 진행 횟수를 입력받는 기능**
  - 정수형이 아니면 예외 발생 ex) 다섯번, 1.5
  - 양수가 아니면 예외 발생 ex) -2, 0
  
- **1-10 사이의 랜덤한 값을 생성하는 기능**

- **슈펴 배팅을 사용할 것인지 입력받는 기능**
  - 1 혹은 2가 아닌 다른 입력시 예외 발생
  
- **배팅 금액을 입력하는 기능**
  - 정수형이 아니면 예외 발생 ex) 천원, 1500.5
  - 양수가 아니면 예외 발생 ex) 0
  - 1000원 단위가 아니면 예외 발생 ex) 1500
  - 내가 가진 금액보다 배팅 금액이 많으면 예외 발생
  
- **사용자로 부터 홀/짝을 입력받는 기능**
  - 1 혹은 2가 아니면 예외 발생
  
- **홀/짝 맞혔을 때 돈의 이동 로직 구현**
  - 맞았으면 배팅금액만큼 상대방으로부터 획득
  - 틀렸으면 배팅금액을 상대방에게 빼앗김

- **홀/짝 맞았는 지 판단하는 기능**

- **일반모드(슈퍼베팅 미사용) 진행 로직 구현**

- **슈퍼배팅 모드 진행 로직 구현**
  - 숫자를 맞히면 상대방 돈 모두 가져온 후 게임 종료
  - 틀리면 재고의 절반 빼앗김

- **한 라운드가 끝나고 게임이 종료되었는지 확인**
  - 둘 중 자금이 0인 되면 시도 횟수가 남아도 게임 종료

- **최종 승자를 결정하는 기능**

- **최종 승자를 출력하는 기능**
  - 무승부이면 "무승부입니다. " 출력
  - 승자가 한 명이면 이름과 순 수익 출력

- **한 라운드가 끝나면 현재 자금 상태를 출력하는 기능**

- **게임 전체 진행 로직 구현**
<br>

## 실행 화면
<img src="/images/실행화면.png" width="50%" height="50%">
