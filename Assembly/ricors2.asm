#Si scriva la routine assembler MIPS che implementa la funzione ricorsiva definita come segue:
#f(x,y,z) = 1 se x,y,z sono tutti 0
#f(x,y,z) = x * f(z+1,x-2,y) altrimenti
#Si assuma che x,y,z siano immessi da input sempre maggiori o uguali a 0
.globl main
.data
warn:.asciiz "input must be greater than 0"
.text
main:

li $v0, 5
syscall #x
blez $v0, error
move $a0, $v0

li $v0, 5
syscall #y
blez $v0, error
move $a1, $v0

li $v0, 5
syscall #z
blez $v0, error
move $a2, $v0

jal funzione

move $a0, $a3
li $v0, 1
syscall

li $v0, 10
syscall

#errore------------------------------------------------------------------------------------------------
error:
la $a0, warn

li $v0, 4
syscall

li $v0, 10
syscall

#funzione----------------------------------------------------------------------------------------------
funzione:
bgtz $a0 notzero
bgtz $a1 notzero
blez $a2 casobase

notzero:

subu $sp, $sp, 4
sw $a0,0($sp) 

move $t0, $a0		#xyz -> #zxy
move $t1, $a1

move $a0, $a2
move $a1, $t0
move $a2, $t1


add $a0, $a0, 1
add $a1, $a1, -2


subu $sp, $sp, 4
sw $ra,0($sp) 

add $s0, $s0, 1
jal funzione

lw $t1, 0($sp)
addu $sp, $sp, 4
lw $t0, 0($sp)
addu $sp, $sp, 4
mul $a3, $t0, $a3
jr $t1




casobase:
li $a3,1
jr $ra



