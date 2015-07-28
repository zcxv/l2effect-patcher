class 4289 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		offset=(X=1.800000,Y=0.000000,Z=-0.800000)
		EffectClass=Class'LineageEffect.mu_wyvern_breath_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mu_wyvern_breath_ta'
		bOnMultiTarget=True
	End Object
	Desc="와이번 브레스" //Wyvern Breath
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ExplosionActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
	ExplosionActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
	FlyingTime=0.400000
}