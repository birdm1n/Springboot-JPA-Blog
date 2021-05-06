let index = {

    init: function () {
        $("#btn-save").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.save();

        }),

        $("#btn-update").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.update();

        });

        /*$("#btn-login").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.login();

        });*/
    },

    save: function () {

        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        };


        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data), // http body data
            contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            console.log(resp);
            location.href = "/";

        }).fail(function (error) {
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    },
    update: function () {

        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()

        };


        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data), // http body data
            contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            console.log(resp);
            location.href = "/";

        }).fail(function (error) {
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    }

    /* login: function(){

         let data = {
             username: $("#username").val(),
             password: $("#password").val()

         };


         // ajax 호출시 default는 비동기 호출
         $.ajax({
             type:"POST",
             url:"/api/user/login",
             data: JSON.stringify(data), // http body data
             contentType:"application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
             dataType:"json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
             //회원가입 수행요청
         }).done(function (resp){
             //성공적이게 끝나면 실행
             alert("로그인 완료.")
             location.href = "/";

         }).fail(function (error){
             // 실패하면 실행
             alert(JSON.stringify(error));
         }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
         //insert 요청청
     }*/

}
index.init();
