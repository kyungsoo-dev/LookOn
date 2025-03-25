무신사 사전 과제인 [상품 전시 화면 만들기] 안드로이드 앱입니다.  

## 🚀 주요 기능
- 배너를 배치하여 시즌별 할인 및 프로모션 정보 제공
  - parallax한 스와이프
  - 3초 간격으로 자동 스와이프
- 클리어런스 섹션 및 인기 브랜드 상품 소개
  - 상품의 할인율 및 쿠폰 제공 강조
- 무신사 추천 코디를 통해 다양한 스타일링 예시 제공
  - 그리드 레이아웃으로 다양한 스타일링을 한눈에 볼 수 있게 배치
- 컨텐츠 하단에 "새로운 추천" 및 "더보기" 버튼 추가
  - 사용자에게 추가 상품 제공 기능

## IDE 환경
- Android Studio Meerkat | 2024.3.1

## SDK 버전 
- minSDK : 28
- targetSDK 35

## 🛠 기술 스택
- **Language**: Kotlin
- **UI**: Jetpack Compose
- **DI**: Hilt
- **Network**: Retrofit + OkHttp
- **Image**: Coil

## 🔧 설치 및 실행 방법
```bash
git clone https://github.com/kyungsoo-dev/LookOn.git
cd LookOn
./gradlew build
```
또는 
Github Repository를 Clone 한 뒤, Android Studio IDE에서 Run 'app' 버튼을 클릭하여 실행하실 수 있습니다.

## 🏗️ 아키텍처
이 프로젝트는 **MVVM (Model-View-ViewModel)** 패턴을 따릅니다.

```
📂 com.musinsa.android.interview.pretest
 ┣ 📂 api               # retrofit api interface
 ┣ 📂 common            # 공통 상수 모음
 ┣ 📂 core              # Application
 ┣ 📂 di                # Hilt 의존성 주입 설정
 ┣ 📂 domain            # 데이터 클래스 모음
 ┣ 📂 extension         # 확장 함수 모음
 ┣ 📂 http              # 데이터 클래스 모음
 ┣ 📂 repository        # 레포지토리 클래스 모음
 ┣ 📂 storage           # 데이터 저장 관련 클래스 모음
 ┣ 📂 type              # Enum 클래스 모음
 ┣ 📂 utils             # 공통으로 사용되는 유용한 함수 모음
 ┗ 📂 views             # 화면 관련 클래스 및 함수 모음
    ┣ 📂 components     # 재사용을 고려한 UI들을 모아둔 클래스 모음
    ┗ 📂 theme          # 디자인 시스템 클래스 모음
```

## 📜 라이선스
이 프로젝트는 MIT 라이선스를 따릅니다. [자세히 보기](LICENSE)
