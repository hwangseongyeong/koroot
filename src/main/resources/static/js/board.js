const boardInfoId = $('#boardInfoId').val();

function initTable() {
    const $table = $('#table');
    $table.bootstrapTable('destroy').bootstrapTable({
        url: '/api/board/list?boardInfoId=' + boardInfoId,
        locale: "ko-KR",
        columns: [
            {
                title: '번호',
                field: 'boardNo',
                align: 'center',
                width: 50
            }, {
                title: '제목',
                field: 'title',
                align: 'left',
                halign: 'center',
                width: 500
            }, {
                title: '작성자',
                field: 'createdBy',
                align: 'center',
                width: 50
            }, {
                title: '등록일',
                field: 'createdAt',
                align: 'center',
                formatter: util.dateFormatter,
                width: 50
            }, {
                title: '조회수',
                field: 'hit',
                align: 'center',
                width: 50
            }
        ]
    });

    $table.on('click-row.bs.table', function (e, rowData) {
        location.href="/board/" + rowData.boardPostId + "/detail";
    });
}