require'tk'

include Math

def plot(val)
  Integer(val * 180 + 200)
end

TkRoot.new do|root|
  title "Curves"
  geometry"400x400"
  TkCanvas.new(root)do|canvas|
    width 400
    height 400
    pack('side'=>'top','fill'=>'both','expand'=>'yes')
    points = [ ]
    a = 2
    b =3
    0.0.step(8, 0.1)do|t|
      x = Math.sin(a*t)
      y = Math.cos(b*t)
      points << plot(x) << plot(y)
    end
    TkcLine.new(canvas, *(points), smooth:'on', width: 10, fill:'blue')
  end
end
Tk.mainloop