export class SVGData {
    constructor(svgPath, initialIsOn = false) {
      this.svgPath = svgPath;
      this.isOn = initialIsOn;
    }
    toggle() {
      this.isOn = !this.isOn;
    }
}