export class SVGDrowing {
    svgPath = [];
    svgName = '';
    imageId = '';
    wight = 0;
    height = 0;
    description = '';
    constructor(svgPath,name,photoId,weight,height,description = false) {
        this.svgPath = [...svgPath];
        this.svgName = name;
        this.imageId = photoId;
        this.wight = weight;
        this.height = height;
        this.description = description;
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
    setName(name) {
        this.svgName = name;
    }
    setWeightHeight(weight,height) {
        this.wight = weight;
        this.height = height;
    }
    setDescription(description) {
        this.description = description;
    }
}