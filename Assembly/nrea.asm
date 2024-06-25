#Scrivere un programma in linguaggio assembaltivo MIPS/MARS che legga da tastiera cinque numeri interi e stampi
#su videoterminale il risultato della media tra i cinque numeri
.globl main
.data
cacca:.double 5.0
.text
main:

li, $v0,5
syscall
move $t0, $v0

li, $v0,5
syscall
move $t1, $v0


li, $v0,5
syscall
move $t2, $v0



li, $v0,5
syscall
move $t3, $v0


li, $v0,5
syscall
move $t4, $v0

add $t0,$t0, $t1
add $t0,$t0, $t2
add $t0,$t0, $t3
add $t0,$t0, $t4

mtc1 $t0, $f0
cvt.d.w $f0, $f0

l.d $f2, cacca



div.d $f0, $f0, $f2

mov.d $f12, $f0


li, $v0, 3
syscall
li, $v0, 10
syscall





