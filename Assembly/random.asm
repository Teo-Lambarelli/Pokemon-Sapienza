.globl main

.data

array:.space 3
space:.asciiz " "

.text
main:
la $t0, array
la $t7, array
li $t8, 999
sb $t8, 0($t7)
addi $t7, $t7, 1
sb  $t8, 0($t7)
addi $t7, $t7, 1
sb $t8, 0($t7)

loop:
la $t7, array
beq $t1, 3, end
li $a1, 91
li $v0, 42
syscall

lb $t9, 0($t7)
beq $t9, $a0, loop
add $t7, $t7, 1
lb $t9, 0($t7)
beq $t9, $a0 ,loop
add $t7, $t7, 1
lb $t9, 0($t7)
beq $t9, $a0, loop

sb $a0, 0($t0)
addi $t0, $t0, 1
addi $t1, $t1, 1
li $v0, 1
syscall
la $a0, space
li $v0, 4
syscall
j loop
end:
li $v0, 10
syscall

