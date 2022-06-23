var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
        $('#btn-update').on('click', function(){
                    _this.update();
                });
        $('#btn-delete').on('click', function(){
            _this.delete();
        });
    },
    save : function() {
        var data = {
            stId: $('#stId').val(),
            stTel: $('#stTel').val()
        };

        $.ajax({
            type: 'POST'
            , url: '/api/v1/teacher'
            , dataType: 'json'
            , contentType: 'application/json; charset=utf-8'
            , data: JSON.stringify(data)
        }).done(function() {
            alert('강사가 등록되었습니다.');
            window.location.href='/';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    },
    update: function(){
        var data = {
            stId: $('#stId').val(),
            stTel: $('#stTel').val()
        };

        var stSeq = $('#stSeq').val();

        $.ajax({
            type: 'PUT'
            , url: '/api/v1/teacher/'+stSeq
            , dataType: 'json'
            , contentType: 'application/json; charset=utf-8'
            , data: JSON.stringify(data)
        }).done(function(){
            alert('강사정보가 수정되었습니다.');
            window.location.href='/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
    ,delete : function() {
        var stSeq = $('#stSeq').val();

        $.ajax({
            type: 'DELETE'
            , url: '/api/v1/teacher/'+stSeq
            , dataType: 'json'
            , contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('강사가 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();