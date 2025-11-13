const img = new Image()
img.src = "data:image/png;base64,REPLACE_WITH_BASE64_IMAGE"
img.onload = () => {
  document.getElementById('frame')!.appendChild(img)
  (document.getElementById('res')!).textContent = `${img.width}x${img.height}`
  (document.getElementById('fps')!).textContent = `sample`
}
