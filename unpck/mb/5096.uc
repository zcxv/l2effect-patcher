class 5096 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect33
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.s_u804_c_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect34
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.e_u829_ta'
	End Object
	Desc="안타라스 부하 원거리공격" //Antharas load ranged
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect33',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect34',SpecificStage=0)
}