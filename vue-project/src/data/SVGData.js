
export class SVGData {

  constructor(svgPath, id, svgName, ImageId, width, Height, description, initialIsOn = false) {
    this.svgPath = svgPath;
    this.isOn = initialIsOn;
    this.id = id;
    this.svgName = svgName;
    this.imageId = ImageId;
    this.width = width;
    this.height = Height;
    this.description = description;
  }
  changeTrue() {
    this.isOn = true;
  }
  changeFalse() {
    this.isOn = false;
  }
}