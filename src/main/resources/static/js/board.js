let index = {

    init: function () {
        $("#btn-save").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.save();

        });
        $("#btn-delete").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.deleteById();

        });
        $("#btn-update").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.update();

        });
        $("#btn-reply-save").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.replySave();

        });

        /*$("#btn-login").on("click", () => { // function(){} 를 ()=>{} 하는 이유는 this를 반인딩하기 위해서임.

            this.login();

        });*/
    },

    save: function () {

        let data = {
            title: $("#title").val(),
            content: $("#content").val(),


        };


        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data), // http body data
            contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            alert("글쓰기 완료")
            location.href = "/";

        }).fail(function (error) {
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    },

    deleteById: function () {
        let id = $("#id").text();
        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            alert("삭제 완룍  ")
            location.href = "/";

        }).fail(function (error) {
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    },

    update: function () {
        let id = $("#id").val();

        let data = {
            title: $("#title").val(),
            content: $("#content").val(),


        };


        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "PUT",
            url: "/api/board/" + id,
            data: JSON.stringify(data), // http body data
            contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            alert("수정 완료")
            location.href = "/";

        }).fail(function (error) {
            // 실패하면 실행
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여
        //insert 요청청
    },

    replySave: function () {

        let data = {
            userId: $("#userId").val(),
            boardId: $("#boardId").val(),
            content: $("#reply-content").val()

        };



        // ajax 호출시 default는 비동기 호출
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data), // http body data
            contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
            dataType: "json" // 서버에서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 json이면) => js로 변경해줌.
            //회원가입 수행요청
        }).done(function (resp) {
            //성공적이게 끝나면 실행
            alert("댓글 작성 완료");
            location.href = `/board/${data.boardId}`;

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
