# cafe-kiosk

이 프로젝트는 Domain-Driven Design (DDD) 원칙을 카페 키오스크 시스템에 적용한 사례입니다.
다음과 같은 DDD의 핵심 요소에 초점을 맞추어 설계되었습니다:

- 엔티티(Entity)
- 애그리거트 루트(Aggregate Root)
- 값 객체(Value Object)
- 리포지토리(Repository)

## 유스케이스

[/ > docs > usecases.md](https://github.com/ahn-sj/cafe-kiosk/blob/main/docs/usecase.md)

## 도메인 모델
- 주문 (Order)
  - 주문 (Aggregate Root)
  - 주문 항목(OrderItem)
  - 주문 옵션 그룹(OrderOptionGroup)
  - 주문 옵션(OrderOption)
- 매장 (Shop)
  - 매장 (Aggregate Root)
- 메뉴 (Menu)
  - 메뉴 (Aggregate Root)
  - 메뉴 옵션(MenuOption)
  - 메뉴 옵션 그룹(MenuOptionGroup)
  - 메뉴 카테고리(MenuCategory)
- 기기 (Machine)
  - 기기 (Aggregate Root)
  - 제조사(Manufacturer)
- 정산 (Settlement)
  - 정산 (Aggregate Root)
- 영수증 (Receipt)
  - 영수증 (Aggregate Root)
- 직원 (Staff)
  - 직원 (Aggregate Root)

