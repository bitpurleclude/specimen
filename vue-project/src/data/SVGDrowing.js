export class SVGDrowing {
    constructor(svgPath,name,photoId = false) {
        this.svgPath = [...svgPath];
        this.name = name;
        this.photoId = photoId;
    }
    StartPath(x,y) {
        this.svgPath.push(`M ${x} ${y}`);
    }
    addPath(x,y) {
        this.svgPath.push(`L ${x} ${y}`);
    }
    EndPath() {
        this.svgPath.push('Z');
    }
}