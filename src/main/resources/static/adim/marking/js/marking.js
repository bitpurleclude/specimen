
document.getElementById('file').addEventListener('change', function() {
    var fileInput = document.getElementById('file');
    var file = fileInput.files[0];
    var reader = new FileReader();

    reader.onload = function(e) {
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

imageDisplay.addEventListener('mousedown', function(e) {
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

imageDisplay.addEventListener('mousemove', function(e) {
    if (!isDrawing) return;
    var x = e.clientX - imageDisplay.offsetLeft;
    var y = e.clientY - imageDisplay.offsetTop;
    points.push({x: x, y: y});

    var d = 'M' + points.map(function(point) { return point.x + ' ' + point.y; }).join(' L');
    path.setAttribute('d', d);
});

imageDisplay.addEventListener('mouseup', function() {
    isDrawing = false;
    points = [];
});