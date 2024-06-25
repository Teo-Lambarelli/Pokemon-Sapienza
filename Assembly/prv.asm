.globl main

.data
due:.float 2
.text

main:

li $v0,5 #Leggo il primo valore
syscall
move $t0,$v0
li $v0,5 #Leggo il secondo valore
syscall
move $t1,$v0
add $t0,$t0,$t1#sommo i valori
mtc1 $t0,$f0 #sposto il valore in $f0 (senza convertirlo)
cvt.s.w $f0,$f0 #converto il valore in standard IEEE 754
lwc1 $f3,due #carico il valore 2.0
div.s $f0,$f0,$f3 #media in $f0
li $v0,5 #Leggo il terzo valore
syscall
move $t2,$v0
li $v0,5 #Leggo il quarto valore
syscall
move $t3,$v0
add $t2,$t2,$t3 #sommo i valori
mtc1 $t2,$f1 #sposto il valore in $f0 (senza convertirlo)
cvt.s.w $f1,$f1 #converto il valore in standard IEEE 754
lwc1 $f3,due #carico il valore 2.0
div.s $f1,$f1,$f3 #media in $f1
c.lt.s 3,$f0,$f1
li $t9,1
bc1f 3, fine
li $t9,0
fine:
li $v0,10
syscall
