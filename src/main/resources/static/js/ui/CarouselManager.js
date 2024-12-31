
class CarouselManager {

    // javascript는 필드는 선언할 필요 없음(생성자에서 선언함)


    // 생성자
    constructor(container) {
        // 캐러셀을 감싸는 전체 부모태그(각 carousl manager 객체가 어디 속하는지 구분하기 위한 용도의 필드)
        this.container = container;

        // 이미지 트랙(실제 이미지가 배치될 공간)
        this.track = this.container.querySelector('.carousel-track');

        // 실제 이미지 파일 배열
        this.slides = [];

    }

    // 기능: 메서드
    // 초기 이미지 파일 배열 받기
    init(files) {
        this.slides = files;
        // 슬라이드 띄우기
        this.setUpPreview();
    }

    // 슬라이드 이미지 렌더링
    setUpPreview() {
        // 이미지 트랙 리셋
        this.track.innerHtml = '';

        this.slides.forEach(file => {
            // 이미지 생성
            const $img = document.createElement('img');
            // raw file을 image url로 변환
            $img.src = URL.createObjectURL(file);

            // 이미지를 감살 박스 생성
            const $slideDiv = document.createElement('div');
            $slideDiv.classList.add('carousel-slide');
            $slideDiv.append($img);

            this.track.append($slideDiv);
        });
    }
}

export default CarouselManager