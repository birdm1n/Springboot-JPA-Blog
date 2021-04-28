let index ={

    init: function () {
        $("#btn-save").on("click", () => {

            this.save();

        });
    },

    save: function(){

        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        };

        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type:"POST",
            url:"/blog/api/user",
            data: JSON.stringify(data), // http body data
            contentType:"application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType:"json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp){
            //성공적이게 끝나면 실행
            alert("회원가입이 완료되었습니다.");
            location.href = "/blog";
        }).fail(function (error){
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    }
}
index.init();
