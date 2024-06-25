.globl main

.data

str:.asciiz "A B"
space:.asciiz " "

.text

main:

lb $t8, space
la $t0, str
la $t9, str

endlen: 

lb $t1, 0($t9)
beqz $t1, end
beq $t1, $t8, removesp
addi $t9, $t9, 1
j endlen

removesp:

addi $t9, $t9, 1
move $t6, $t9

rems:

lb $t5, 0($t6)

subi $t6, $t6, 1
sb $t5, 0($t6)
addi $t6, $t6, 2
beqz $t5, endlen
j rems

end:
move $a0, $t0
li $v0, 4
syscall
li $v0, 10
syscall
