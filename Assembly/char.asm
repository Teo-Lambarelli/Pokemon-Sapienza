globl:.main
#Traccia 1. Realizzare un programma in assembly MARS che, definite due stringhe in memoria di ugual lunghezza,
#calcola la similitudine tra due stringhe. La similitudine è data dal numero dei ceratteri uguali alla stessa posizione diviso la lughezza della stringa.


.data
n0: .asciiz "caccona"
n1: .asciiz "cacchin"

.text

la $t0, n0
la $t1, n1

li $t9, 1
xor $t5, $t5, $t5 #caratteri uguali
xor $t6, $t6, $t6 #lunghezza stringa

cacca:

lb $t8, 0($t0)
lb $t9, 0($t1)
beqz  $t9, end
beq $t8, $t9, uguali


add $t6,$t6, 1


add $t1, $t1, 1
add $t0, $t0, 1

j cacca

uguali:

add $t5,$t5, 1

add $t6,$t6, 1

add $t1, $t1, 1
add $t0, $t0, 1

j cacca


end:
move $a0, $t5
li $v0,1
syscall

move $a0, $t6
li $v0,1
syscall

li $v0,10
syscall
