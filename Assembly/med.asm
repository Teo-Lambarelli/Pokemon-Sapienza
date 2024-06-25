#Si scriva un programma in linguaggio assembly che letti quattro
#numeri interi da tastiera effettua la media dei primi due numeri
#e la media dei secondi due numeri e pone in $t9 il valore 1 se la
#prima media è maggiore della seconda altrimento $t9 è
#impostato a 0

.globl main

.data
due:.float 2
.text

main:

li $v0,5

syscall
move $t0,$v0

li $v0,5
syscall
move $t0,$v0

add $t0,$t0,$t1

mtc1 $t0, $f0
cvt.s.w $f0,$f0

li $v0,5
syscall
move $t0,$v0

li $v0,5
syscall
move $t0,$v0

add $t0,$t0,$t1

mtc1 $t0,$f1
cvt.s.w $f1,$f1

lwc1 $f3,due

div.s $f0,$f0,$f3 
div.s $f1,$f1,$f3 


c.lt.s 1, $f0,$f1
li $t9,1

bc1f 1, fine


li $t9,0

fine:
li $v0,10
syscall

