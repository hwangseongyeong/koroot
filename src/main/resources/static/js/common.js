function dateFormatter(value) {
    let d = new Date(value)
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate()
    let year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
}

function initTable() {
    const $table = $('#table');
    $table.bootstrapTable('destroy').bootstrapTable({
        locale: "ko-KR",
        columns: [
            {
                title: '번호',
                field: 'boardId',
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
                formatter: dateFormatter,
                width: 50
            }, {
                title: '조회수',
                field: 'hits',
                align: 'center',
                width: 50
            }
        ]
    });

    $table.on('click-row.bs.table', function (e, rowData) {
        let type = $('#boardType').val();
        location.href="/board/detail?boardId=" + rowData.boardId + "&type=" + type;
    });
}