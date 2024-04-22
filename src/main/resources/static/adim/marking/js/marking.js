document.getElementById('file').addEventListener('change', function () {
    var fileInput = document.getElementById('file');
    var file = fileInput.files[0];
    var reader = new FileReader();

    reader.onload = function (e) {
        var dataUrl = e.target.result;
        document.getElementById('imageDisplay').src = dataUrl;
    };

    reader.readAsDataURL(file);
});


var isDrawing = false;
var points = [];
var path;

var imageDisplay = document.getElementById('imageDisplay');
var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
svg.setAttribute('width', imageDisplay.offsetWidth);
svg.setAttribute('height', imageDisplay.offsetHeight);
svg.style.position = 'absolute';
svg.style.top = imageDisplay.offsetTop + 'px';
svg.style.left = imageDisplay.offsetLeft + 'px';
svg.style.zIndex = 1;
svg.style.pointerEvents = 'none';
document.body.appendChild(svg);
imageDisplay.parentNode.appendChild(svg);

imageDisplay.addEventListener('mousedown', function (e) {
    e.preventDefault();
    isDrawing = true;
    if (!isDrawing) return;
    var x = e.clientX - imageDisplay.offsetLeft;
    var y = e.clientY - imageDisplay.offsetTop;
    points.push({x: x, y: y});

    path = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    path.setAttribute('stroke', 'black');
    path.setAttribute('fill', 'none');
    svg.appendChild(path);
});

imageDisplay.addEventListener('mousemove', function (e) {
    if (!isDrawing) return;
    var x = e.clientX - imageDisplay.offsetLeft;
    var y = e.clientY - imageDisplay.offsetTop;
    points.push({x: x, y: y});

    var d = 'M' + points.map(function (point) {
        return point.x + ' ' + point.y;
    }).join(' L');
    path.setAttribute('d', d);
});

imageDisplay.addEventListener('mouseup', function (e) {
    isDrawing = false;
    points = [];

    var tooltip = document.getElementById('tooltip');
    var svgNameInput = document.getElementById('svgName');
    var arrow = document.getElementById('arrow');



    // 当输入框中的值改变时，更新SVG的名字
    svgNameInput.addEventListener('input', function () {
        path.setAttribute('name', svgNameInput.value);
    });

    // SVG绘制完成后，设置pointer-events为none
    svg.style.pointerEvents = 'none';
});
document.getElementById("submit").addEventListener('click', function () {
// 获取文件和SVG路径
    var fileInput = document.getElementById('file');
    var file = fileInput.files[0];
    var svgPath = document.querySelector('svg').children[0];
    var svgName = document.getElementById('svgName').value;
    if (!file || !svgPath || !svgName) {
        return;
    }

// 创建一个FormData对象
    var formData = new FormData();

// 将文件和SVG路径添加到FormData对象中
    formData.append('file', file);
    formData.append('svgPath', svgPath);
    formData.append('svgName', svgName);
// 使用fetch API发送异步请求
    fetch('/marking', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('Error:', error));
});
