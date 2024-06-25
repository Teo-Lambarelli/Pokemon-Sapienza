.data

STR:.asciiz "IERI HO CAGATO I MIEI CACCO"
DIT:.asciiz "AEIOU"
LET:.asciiz "I"

.text
lb $t0, LET
la $t1, STR
la $t2, DIT
move $t3, $t1

li $t8, 0
li $t7, 0

len_str:
lb $t9, 0($t1)
addi $t1,$t1, 1
addi $t8,$t8 1
bnez $t9, len_str


while:
beq $t8, $t7, end
lb $t9, 0($t3)
beq $t9,$t0, check1
addi $t3,$t3, 1
addi $t7,$t7, 1
j while

check1:
li $t6, 0
addi $t3,$t3, 1
la $t2, DIT

check:
lb $t9, 0($t3)
lb $t4, 0($t2)
beq $t9, $t4, agg
addi $t2, $t2, 1
addi $t6, $t6, 1
beq $t6, 4, while
j check

agg:
addi $t5,$t5, 1

move $a0, $t9
li $v0, 1
syscall

j while

end:

move $a0, $t5
li $v0, 1
syscall



li $v0, 10
syscall